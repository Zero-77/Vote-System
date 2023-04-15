package votesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import votesystem.model.Item;
import votesystem.service.ItemService;

import java.util.List;

@Controller
public class ItemController {


	@Autowired
	private ItemService itemService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "name", "asc", model);
	}

	@GetMapping("/AddItem")
	public String addItem(Model model) {
		// create model attribute to bind form data
		Item item = new Item();
		model.addAttribute("item", item);
		return "add_item";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {

		// get item from the service
		Item item = itemService.getItemById(id);
		// set item as a model attribute to pre-populate the form
		model.addAttribute("item", item);
		return "update_item";
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/saveItem")
	public String saveItem(@ModelAttribute("item") Item item) {
		// save item to database
		itemService.saveItem(item);
		return "redirect:/";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
								@RequestParam("sortField") String sortField,
								@RequestParam("sortDir") String sortDir,
								Model model) {
		int pageSize = 5;

		Page<Item> page = itemService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Item> listEmployees = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listEmployees", listEmployees);
		return "index";
	}

	@CrossOrigin(origins = "*")
	@GetMapping("item/deleteItem/{id}")
	public String deleteItem(@PathVariable (value = "id") int id) {

		// call delete item method
		this.itemService.deleteItemById(id);
		return "redirect:/";
	}



	//取得Item
	@CrossOrigin(origins = "*")
	@GetMapping("item/getItem")
	public ResponseEntity<List<Item>> getItemData() {


		List<Item> result = this.itemService.getAllItem();
		System.out.println(result.size());

		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(result);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("item/showFormForUpdate_id/{id}")
	public ResponseEntity<Item> showFormForUpdate_id(@PathVariable ( value = "id") int id) {

		// get Item from the service
		Item item = itemService.getItemById(id);

		return ResponseEntity.ok().body(item);
	}

}

package com.SmoothStack.SmoothStackLoginCaseHub.Service;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.SmoothStack.SmoothStackLoginCaseHub.Entity.Author;
import com.SmoothStack.SmoothStackLoginCaseHub.Entity.Book;
import com.SmoothStack.SmoothStackLoginCaseHub.Entity.Borrower;
import com.SmoothStack.SmoothStackLoginCaseHub.Entity.Publisher;
import com.SmoothStack.SmoothStackLoginCaseHub.Entity.BookCopy;
import com.SmoothStack.SmoothStackLoginCaseHub.Entity.BookLoan;
import com.SmoothStack.SmoothStackLoginCaseHub.Entity.LibraryBranch;

@RestController
@RequestMapping("/lms")
public class MyService {
	
	RestTemplate restTemplate;
	
	//librarian
	@RequestMapping(value = "/librarian/libraryBranch", method = RequestMethod.GET)
	private String librarianDisplayLibraryBranch(){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		return restTemplate.exchange("http://localhost:8081/librarian/libraryBranch", HttpMethod.GET, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/menu/librarian/libraryBranch/{id}", method = RequestMethod.GET)
	private String librarianGetLibraryBranch(@PathVariable("id") int id, @RequestBody LibraryBranch product){
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<LibraryBranch> entity = new HttpEntity<LibraryBranch>(product,headers);
		
		return restTemplate.exchange("http://localhost:8081/librarian/libraryBranch/" + id, HttpMethod.PUT, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/librarian/libraryBranch/{id}", method = RequestMethod.PUT)
	private String librarianUpdateLibraryBranch(@PathVariable("id") int id, @RequestBody LibraryBranch product){
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<LibraryBranch> entity = new HttpEntity<LibraryBranch>(product,headers);
		
		return restTemplate.exchange("http://localhost:8081/librarian/libraryBranch/" + id, HttpMethod.PUT, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/librarian/bookCopies/{bookId}/{branchId}", method = RequestMethod.PUT)
	private String ibrarianUpdateBookCopy(@PathVariable("bookId") int bookId, @PathVariable("branchId") int branchId, @RequestBody BookCopy product){
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<BookCopy> entity = new HttpEntity<BookCopy>(product,headers);
		
		return restTemplate.exchange("http://localhost:8081/librarian/libraryBranch/" + bookId + "/" + branchId, HttpMethod.PUT, entity, String.class).getBody();
	}
	
	//Admin
	//Display
	@RequestMapping(value = "/admin/author", method = RequestMethod.GET)	
	public String adminDisplayAuthor() {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Author> entity = new HttpEntity<Author>(headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/author", HttpMethod.POST, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/admin/book", method = RequestMethod.GET)	
	public String adminDisplayBook() {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Book> entity = new HttpEntity<Book>(headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/book", HttpMethod.POST, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/admin/bookCopy", method = RequestMethod.GET)	
	public String adminDisplayBookCopy() {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Book> entity = new HttpEntity<Book>(headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/bookCopy", HttpMethod.POST, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/admin/bookLoan", method = RequestMethod.GET)	
	public String adminDisplayBookLoan() {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<BookLoan> entity = new HttpEntity<BookLoan>(headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/bookLoan", HttpMethod.POST, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/admin/borrower", method = RequestMethod.GET)	
	public String adminDisplayBorrower() {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Borrower> entity = new HttpEntity<Borrower>(headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/borrower", HttpMethod.POST, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/admin/libraryBranch", method = RequestMethod.GET)	
	public String adminDisplayLibraryBranch() {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Book> entity = new HttpEntity<Book>(headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/libraryBranch", HttpMethod.POST, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/admin/publisher", method = RequestMethod.GET)	
	public String adminDisplayPublisher() {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Book> entity = new HttpEntity<Book>(headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/publisher", HttpMethod.POST, entity, String.class).getBody();
	}
	
	//Add
	@RequestMapping(value = "/admin/author", method = RequestMethod.POST)
	private String adminAddAuthor(@Valid @RequestBody Author product){
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Author> entity = new HttpEntity<Author>(product,headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/author", HttpMethod.POST, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/admin/book", method = RequestMethod.POST)
	private String adminAddBook(@Valid @RequestBody Book product){
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Book> entity = new HttpEntity<Book>(product,headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/book", HttpMethod.POST, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/admin/borrower", method = RequestMethod.POST)
	private String adminAddBorrower(@Valid @RequestBody Borrower product){
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Borrower> entity = new HttpEntity<Borrower>(product,headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/borrower", HttpMethod.POST, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/admin/libraryBranch", method = RequestMethod.POST)
	private String adminAddLibraryBranch(@Valid @RequestBody LibraryBranch product){
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<LibraryBranch> entity = new HttpEntity<LibraryBranch>(product,headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/libraryBranch", HttpMethod.POST, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/admin/publisher", method = RequestMethod.POST)
	private String adminAddPublisher(@Valid @RequestBody Publisher product){
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Publisher> entity = new HttpEntity<Publisher>(product,headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/publisher", HttpMethod.POST, entity, String.class).getBody();
	}
	
	//Update
	@RequestMapping(value = "/admin/author/{id}", method = RequestMethod.PUT)
	private String adminUpdateAuthor(@PathVariable(value = "id") int authorId,
			@Valid @RequestBody Author product){
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Author> entity = new HttpEntity<Author>(product, headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/author/" + authorId, HttpMethod.PUT, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/admin/book/{id}", method = RequestMethod.PUT)
	private String adminUpdateBook(@PathVariable(value = "id") int bookId,
			@Valid @RequestBody Book product){
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Book> entity = new HttpEntity<Book>(product, headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/book/" + bookId, HttpMethod.PUT, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/admin/borrower/{id}", method = RequestMethod.PUT)
	private String adminUpdateBorrower(@PathVariable(value = "id") int cardNo,
			@Valid @RequestBody Borrower product){
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Borrower> entity = new HttpEntity<Borrower>(product, headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/borrower/" + cardNo, HttpMethod.PUT, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/admin/libraryBranch/{id}", method = RequestMethod.PUT)
	private String adminUpdateLibraryBranch(@PathVariable(value = "id") int branchId,
			@Valid @RequestBody LibraryBranch product){
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<LibraryBranch> entity = new HttpEntity<LibraryBranch>(product, headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/libraryBranch/" + branchId, HttpMethod.PUT, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/admin/publisher/{id}", method = RequestMethod.PUT)
	private String adminUpdatePublisher(@PathVariable(value = "id") int publisherId,
			@Valid @RequestBody Publisher product){
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Publisher> entity = new HttpEntity<Publisher>(product, headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/publisher/" + publisherId, HttpMethod.PUT, entity, String.class).getBody();
	}
	
	//Delete
	@RequestMapping(value = "/admin/author/{id}", method = RequestMethod.DELETE)
	private String adminDeleteAuthor(@PathVariable(value = "id") int authorId){
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Author> entity = new HttpEntity<Author>(headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/author/" + authorId, HttpMethod.DELETE, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/admin/book/{id}", method = RequestMethod.DELETE)
	private String adminDeleteBook(@PathVariable(value = "id") int bookId){
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Book> entity = new HttpEntity<Book>(headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/book/" + bookId, HttpMethod.DELETE, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/admin/borrower/{id}", method = RequestMethod.DELETE)
	private String adminDeleteBorrower(@PathVariable(value = "id") int cardNo){
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Borrower> entity = new HttpEntity<Borrower>(headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/borrower/" + cardNo, HttpMethod.DELETE, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/admin/libraryBranch/{id}", method = RequestMethod.DELETE)
	private String adminDeleteLibraryBranch(@PathVariable(value = "id") int branchId){
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<LibraryBranch> entity = new HttpEntity<LibraryBranch>(headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/libraryBranch/" + branchId, HttpMethod.DELETE, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/admin/publisher/{id}", method = RequestMethod.DELETE)
	private String adminDeletePublisher(@PathVariable(value = "id") int publisherId){
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Publisher> entity = new HttpEntity<Publisher>(headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/publisher/" + publisherId, HttpMethod.DELETE, entity, String.class).getBody();
	}
	
	//override book loan
	@RequestMapping(value = "/admin/extendBookLoan/{bookId}/{libraryBranchId}/{cardNo}", method = RequestMethod.PUT)
	private String adminExtendBookLoan(@PathVariable(value = "bookId") int bookId,
			@PathVariable(value = "libraryBranchid") int libraryBranchId,
			@PathVariable(value = "cardNo") int cardNo){
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<BookLoan> entity = new HttpEntity<BookLoan>(headers);
		
		return restTemplate.exchange("http://localhost:8082/admin/extendBookLoan/" + bookId + "/" + libraryBranchId + "/" + cardNo, HttpMethod.PUT, entity, String.class).getBody();
	}
	
	//Borrower
	@RequestMapping(value = "/borrower/bookLoan", method = RequestMethod.POST)
	private String borrowerAddBookLoan(@Valid @RequestBody BookLoan product){
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<BookLoan> entity = new HttpEntity<BookLoan>(product,headers);
		
		return restTemplate.exchange("http://localhost:8083/borrower/bookLoan", HttpMethod.POST, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/borrower/returnBookLoan/{bookId}/{libraryBranchId}/{cardNo}", method = RequestMethod.PUT)
	private String borrowerReturnBookLoan(@PathVariable(value = "bookId") int bookId,
			@PathVariable(value = "libraryBranchid") int libraryBranchId,
			@PathVariable(value = "cardNo") int cardNo){
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<BookLoan> entity = new HttpEntity<BookLoan>(headers);
		
	      return restTemplate.exchange("http://localhost:8083/borrower/returnBookLoan/" + bookId + "/" + libraryBranchId + "/" + cardNo, HttpMethod.PUT, entity, String.class).getBody();
	}
}

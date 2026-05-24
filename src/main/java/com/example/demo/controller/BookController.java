package com.example.demo.controller;
import com.example.demo.common.Result;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService BookService;
    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public Result list(){
    return Result.success(bookService.list());
}
    @GetMapping ("/{id}")
        public Result getById(@PathVariable Integer id) {
       return Result.success(bookService.getById(id));
    }
    @PostMapping
    public Result add(@RequestBody Book book){
        return Result.success(bookService.add(book));
    }
    @PutMapping
    public Result update(@RequestBody Book book){
        return Result.success(bookService.update(book));
    }
    @DeleteMapping("/{id}")
   public Result delete(@PathVariable Integer id){
        return Result.success(bookService.delete(id));
    }


}
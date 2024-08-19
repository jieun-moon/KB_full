package org.scoula.controller;


import lombok.RequiredArgsConstructor;
import org.scoula.dto.BookDTO;
import org.scoula.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @GetMapping("")
    public ResponseEntity<List<BookDTO>> getList() {
        return ResponseEntity.ok(service.getAllBooks());
    }

    @GetMapping("/{no}")
    public ResponseEntity<BookDTO> get(@PathVariable Integer id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping("")
    public ResponseEntity<BookDTO> create(@RequestBody BookDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{no}")
    public ResponseEntity<BookDTO> update(@PathVariable int id, @RequestBody BookDTO dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        Boolean result = service.delete(id);
        return ResponseEntity.ok(result);
    }

}

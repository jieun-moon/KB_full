package org.scoula.service;

import org.scoula.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface BookService {
    public List<BookDTO> getAllBooks();

    public BookDTO get(Integer id);

    public BookDTO create(BookDTO book);

    public BookDTO update(BookDTO book);

    public boolean delete(Integer id);


}

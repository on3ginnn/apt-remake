package com.aptproject.SpringLibraryProject.library.mapper;

import com.aptproject.SpringLibraryProject.library.dto.AuthorDTO;
import com.aptproject.SpringLibraryProject.library.dto.BookRentInfoDTO;
import com.aptproject.SpringLibraryProject.library.model.Author;
import com.aptproject.SpringLibraryProject.library.model.BookRentInfo;
import com.aptproject.SpringLibraryProject.library.model.GenericModel;
import com.aptproject.SpringLibraryProject.library.repository.BookRepository;
import com.aptproject.SpringLibraryProject.library.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class BookRentInfoMapper extends GenericMapper <BookRentInfo, BookRentInfoDTO> {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookRentInfoMapper(ModelMapper modelMapper,
                              BookRepository bookRepository,
                              UserRepository userRepository) {
        super(BookRentInfo.class, BookRentInfoDTO.class, modelMapper);
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }


    @Override
    protected void setupMapper() {
        modelMapper.createTypeMap(BookRentInfo.class, BookRentInfoDTO.class)
                .addMappings(mapping -> mapping.skip(BookRentInfoDTO::setBookId))
                .addMappings(mapping -> mapping.skip(BookRentInfoDTO::setUserId))
                .setPostConverter(toDTOConverter());
        modelMapper.createTypeMap(BookRentInfoDTO.class, BookRentInfo.class)
                .addMappings(mapping -> mapping.skip(BookRentInfo::setUser))
                .addMappings(mapping -> mapping.skip(BookRentInfo::setBook))
                .setPostConverter(toEntityConverter());
    }

    protected void mapSpecificFields(BookRentInfoDTO source, BookRentInfo destination) {
        destination.setBook(bookRepository.findById(source.getBookId()).orElseThrow(() ->
        new NotFoundException("Книга не найдена")));
        destination.setUser(userRepository.findById(source.getUserId()).orElseThrow(() ->
                new NotFoundException("Пользователь не найден")));
    }

    protected void mapSpecificFields(BookRentInfo source, BookRentInfoDTO destination) {
        destination.setUserId(source.getId());
        destination.setBookId(source.getId());
    }

    @Override
    protected List<Long> getIds(BookRentInfo source) {
      throw new UnsupportedOperationException("Метода недоступен");
    }
}

package com.aptproject.SpringLibraryProject.library.mapper;

import com.aptproject.SpringLibraryProject.library.dto.UserDTO;
import com.aptproject.SpringLibraryProject.library.model.GenericModel;
import com.aptproject.SpringLibraryProject.library.model.User;
import com.aptproject.SpringLibraryProject.library.repository.BookRentInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserMapper extends GenericMapper <User, UserDTO> {

    private final BookRentInfoRepository bookRentInfoRepository;

    public UserMapper(ModelMapper modelMapper,
                      BookRentInfoRepository bookRentInfoRepository) {
        super(User.class, UserDTO.class, modelMapper);
        this.bookRentInfoRepository = bookRentInfoRepository;
    }

    @Override
    protected void setupMapper() {
        modelMapper.createTypeMap(User.class, UserDTO.class)
                .addMappings(mapping -> mapping.skip(UserDTO::setUserBooksRent))
                .setPostConverter(toDTOConverter());
        modelMapper.createTypeMap(UserDTO.class, User.class)
                .addMappings(mapping -> mapping.skip(User::setBookRentInfos))
                .setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFields(UserDTO source, User destination) {
        if (!Objects.isNull(source.getUserBooksRent())) {
            destination.setBookRentInfos(bookRentInfoRepository
                    .findAllById(source.getUserBooksRent()));
        } else
            destination.setBookRentInfos(Collections.emptyList());
    }

    @Override
    protected void mapSpecificFields(User source, UserDTO destination) {
        destination.setUserBooksRent(getIds(source));
    }

    @Override
    protected List<Long> getIds(User source) {
        return Objects.isNull(source) || Objects.isNull(source.getBookRentInfos())
                ? null
                : source.getBookRentInfos().stream()
                .map(GenericModel::getId)
                .collect(Collectors.toList());
    }
}

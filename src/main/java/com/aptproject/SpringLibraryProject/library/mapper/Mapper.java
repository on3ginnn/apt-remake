package com.aptproject.SpringLibraryProject.library.mapper;

import com.aptproject.SpringLibraryProject.library.dto.GenericDTO;
import com.aptproject.SpringLibraryProject.library.model.GenericModel;

import java.util.List;

public interface Mapper<E extends GenericModel, D extends GenericDTO> {

    /**
     * метод, который преобразует DTO в сущность
     */
    E toEntity(D dto);

    /**
     * метод, который преобразует сущность в DTO
     */
    D toDTO(E entity); //


    /**
     * метод, который преобразует список DTO в список сущностей
     */
    List<E> toEntities(List<D> dtos);

    /**
     * метод, который преобразует список DTO в список сущностей
     */

    List<D> toDTOs(List<E> entities);
}

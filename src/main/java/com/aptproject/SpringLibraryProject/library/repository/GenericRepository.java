package com.aptproject.SpringLibraryProject.library.repository;

import com.aptproject.SpringLibraryProject.library.model.GenericModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Абстрактный репозиторий
 * Необходим для работы абстрактного сервиса
 * т.к. в абстрактном сервисе мы не можем использовать конкретный репозиторий,
 * а должны указывать параметризованный (GenericRepository)
 * @param <T> - Сущность, с которой работает репозиторий
 */

@NoRepositoryBean // не даст создать репозиторий, т.к. он абстрактный. Аналог @MappedSuperclass у GenericModel
public interface GenericRepository <T extends GenericModel> extends JpaRepository<T, Long> { // Ограничиваем работу
    // только с моделями, которые наследуются от GenericModel
}

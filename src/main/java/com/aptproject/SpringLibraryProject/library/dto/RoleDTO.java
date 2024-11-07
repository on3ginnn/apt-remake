package com.aptproject.SpringLibraryProject.library.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter
@Setter
public class RoleDTO {

    private Long Id;
    private String title;
    private String description;
}

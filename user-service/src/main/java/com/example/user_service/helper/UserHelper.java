package com.example.user_service.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.example.user_service.Dto.AddressDto;
import com.example.user_service.Dto.CredentialDto;
import com.example.user_service.Dto.UserDto;
import com.example.user_service.model.Address;
import com.example.user_service.model.Credential;
import com.example.user_service.model.UserProfile;

public interface UserHelper {

    // ===================== ENTITY → DTO =====================
    static UserDto map(UserProfile userProfile) {

        if (userProfile == null) return null;

        UserDto dto = new UserDto();
        BeanUtils.copyProperties(userProfile, dto);

        // Credential
        if (userProfile.getCredential() != null) {
            CredentialDto c = new CredentialDto();
            BeanUtils.copyProperties(userProfile.getCredential(), c);
            dto.setCredentialdto(c);
        }

        // Address
        if (userProfile.getAddress() != null) {
            List<AddressDto> addressDtos =
                    userProfile.getAddress()
                            .stream()
                            .map(AddressHelper::map)
                            .collect(Collectors.toList()); // ✅ MUTABLE

            dto.setAddress(addressDtos);
        }

        return dto;
    }

    // ===================== DTO → ENTITY =====================
    static UserProfile map(UserDto dto) {

        if (dto == null) return null;

        UserProfile user = new UserProfile();
        BeanUtils.copyProperties(dto, user);

        // Credential
        if (dto.getCredentialdto() != null) {
            Credential c = new Credential();
            BeanUtils.copyProperties(dto.getCredentialdto(), c);
            c.setUser(user);
            user.setCredential(c);
        }

        // Address
        if (dto.getAddress() != null && !dto.getAddress().isEmpty()) {

            List<Address> addresses =
                    dto.getAddress()
                            .stream()
                            .map(AddressHelper::map)
                            .collect(Collectors.toList()); // ✅ MUTABLE

            addresses.forEach(a -> a.setUser(user));
            user.setAddress(addresses);
        }

        return user;
    }
}

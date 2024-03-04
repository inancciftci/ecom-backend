package com.example.eComBackend.dto;

import java.util.List;

public record RoleResponseWithUsers(String name, String code, List<String> userEmails) {
}

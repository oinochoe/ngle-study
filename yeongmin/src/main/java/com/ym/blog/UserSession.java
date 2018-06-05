package com.ym.blog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSession {
	private String providerUserId;
	private String imageUrl;
	private String displayName;
}

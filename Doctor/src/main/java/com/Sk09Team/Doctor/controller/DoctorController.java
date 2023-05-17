package com.Sk09Team.Doctor.controller;
import com.Sk09Team.Doctor.service.DoctorService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    /*
    @Value("${DOCTOR-SERVICE.app.jwtSecret}")
    private String jwtSecret;
    // Helper method to authenticate the doctor using the JWT token
    private boolean isValidDoctor(String token, Long doctorId) {
        String jwtToken = token.substring(7);
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwtToken).getBody();
        } catch (JwtException e) {
            return false;
        }
        String username = claims.getSubject();
        List<String> roles = null;
        Object rolesObj = claims.get("roles");
        if (rolesObj instanceof List<?>) {
            roles = ((List<?>) rolesObj).stream()
                    .filter(role -> role instanceof String)
                    .map(role -> (String) role)
                    .collect(Collectors.toList());
        }
        Long userId = null;
        Object userIdObj = claims.get("userId");
        if (userIdObj instanceof Integer) {
            userId = ((Integer) userIdObj).longValue();
        } else if (userIdObj instanceof Long) {
            userId = (Long) userIdObj;
        }
        return (username != null && userId != null && userId.equals(doctorId) && roles != null && roles.contains("ROLE_DOCTOR"));
    }*/
    @PutMapping("/{consultationId}/{doctorId}/approve")
    public ResponseEntity<Long> approveConsultation(@PathVariable("consultationId") Long consultationId,
                                                      @PathVariable("doctorId") Long doctorId) {

        return doctorService.approveConsultation(consultationId,doctorId);
    }



}

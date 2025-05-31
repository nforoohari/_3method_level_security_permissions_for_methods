package ir.digixo.config;

import ir.digixo.entity.Product;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class ProductPermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication authentication, Object target, Object permission) {
        Product product = (Product) target;
        // The permission object in our case is the role name, so we cast it to a String.
        String p = (String) permission;

        System.out.println(p);

        //Checks if the authentication user has the role we got as a parameter
        boolean admin =  authentication.getAuthorities()
                .stream()
                .anyMatch(a -> a.getAuthority().equals(p));

        // If admin or the authenticated user is the owner of the book, grants the permission
        return admin || product.getOwner()
                .equals(authentication.getName());
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {

        return false;
    }
}

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
        String access_permission = (String) permission;

        System.out.println("ProductPermissionEvaluator authentication.getName() : " + authentication.getName());
        System.out.print("ProductPermissionEvaluator authentication.getAuthorities() : ");
        authentication.getAuthorities().forEach(System.out::println);
        System.out.println("ProductPermissionEvaluator target: " + product);
        System.out.println("ProductPermissionEvaluator permission: " + access_permission);

        boolean permission_check = authentication.getAuthorities()
                .stream()
                .anyMatch(a -> a.getAuthority().equals(access_permission));

        System.out.println("ProductPermissionEvaluator permission_check : " + permission_check);

        return permission_check && product.getOwner().equals(authentication.getName());
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}

package com.pinyougou.shop.service;

import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserDetailServiceImpl
 * @author: itXiaoKe
 * @date: 2020/2/24 14:27
 * @Description: 权限框架的实现类
 * @Version: 1.0
 */
public class UserDetailServiceImpl implements UserDetailsService {

    private SellerService sellerService;

    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 获取商家对象
        TbSeller tbSeller = sellerService.findOne(username);
        // 商家对象不为空
        if (tbSeller != null) {
            // 商户状态为 1 的,审核通过的
            String status = "1";
            if (status.equals(tbSeller.getStatus())) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                return new User(username, tbSeller.getPassword(), authorities);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}

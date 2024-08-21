package com.tiga.patient_reg_syst.service;

import com.tiga.patient_reg_syst.entity.Member;
import com.tiga.patient_reg_syst.entity.Roles;
import com.tiga.patient_reg_syst.repository.MemberRepository;
import com.tiga.patient_reg_syst.repository.RoleRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthenticationService {

    private MemberRepository memberRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public AuthenticationService(MemberRepository memberRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public Member register (String email,String password){
        Optional<Member> byEmail = memberRepository.findByEmail(email);
        if(byEmail.isPresent()){
            throw new RuntimeException("Given user email is already exist! Email: " + email );
        }
        String encodedPassword =passwordEncoder.encode(password);

        Set<Roles> rolesSet = new HashSet<>();

        Optional<Roles> adminRole = roleRepository.findByAuthority("ADMIN");
        if(!adminRole.isPresent()){
            Roles adminRoleEntity = new Roles();
            adminRoleEntity.setAuthority("ADMIN");
            Roles savedAdminRole = roleRepository.save(adminRoleEntity);
            rolesSet.add(savedAdminRole);
        }else {
            rolesSet.add(adminRole.get());
        }

      /* Optional<Roles> userRole = roleRepository.findByAuthority("USER");
        if(!userRole.isPresent()){
            Roles userRoleEntity = new Roles();
            userRoleEntity.setAuthority("USER");
            Roles savedUserRole = roleRepository.save(userRoleEntity);
            rolesSet.add(savedUserRole);
        }else {
            rolesSet.add(userRole.get());
        }*/

        Member member = new Member();
        member.setEmail(email);
        member.setPassword(encodedPassword);
        member.setAuthorities(rolesSet);

        return memberRepository.save(member);

    }
}

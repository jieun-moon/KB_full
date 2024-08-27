package org.scoula.security.member.mapper;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.account.domain.AuthVO;
import org.scoula.security.account.domain.MemberVO;
import org.scoula.security.account.mapper.UserDetailsMapper;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class, SecurityConfig.class})
@Log4j
public class UserDetailsMapperTest {
    @Autowired
//    spring security가 생각하는(?) UserDetailsMapper
    private UserDetailsMapper mapper;

    @Test
    public void testGet() {
        MemberVO member = mapper.get("admin");
        log.info(member);

        for(AuthVO auth: member.getAuthList()){
            log.info(auth);
        }
    }
}
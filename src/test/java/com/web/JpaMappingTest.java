package com.web;

import com.web.domain.Board;
import com.web.domain.User;
import com.web.domain.enums.BoardType;
import com.web.repository.BoardRepository;
import com.web.repository.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest
public class JpaMappingTest {
    private final String boardTestTitle = "테스트";
    private final String email = "test@gmail.com";

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardRepository boardRepository;

    @Before("")
    public void init(){
        User user = userRepository.save(User.builder().name("havi").password("test").email(email).createdDate(LocalDateTime.now()).build());

        Board board = boardRepository.save(Board.builder().title(boardTestTitle).subTitle("서브 타이틀").content("콘텐츠").boardType(BoardType.free).createdDate(LocalDateTime.now()).updatedDate(LocalDateTime.now()).user(user).build());
    }

    @Test
    public void 생성_테스트(){
        User user = userRepository.findByEmail(email);
        assertThat(user.getName()).isEqualTo("havi");
        assertThat(user.getPassword()).isEqualTo("test");
        assertThat(user.getEmail()).isEqualTo(email);

        Board board = boardRepository.findByUser(user);
        assertThat(board.getTitle()).isEqualTo(boardTestTitle);
        assertThat(board.getSubTitle()).isEqualTo("서브 타이틀");
        assertThat(board.getContent()).isEqualTo("콘텐츠");
        assertThat(board.getBoardType()).isEqualTo(BoardType.free);
    }

}

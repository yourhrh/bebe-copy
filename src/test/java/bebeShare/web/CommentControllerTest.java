package bebeShare.web;

import bebeShare.domain.comment.Comment;
import bebeShare.domain.comment.CommentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CommentControllerTest {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void delete() throws Exception{
        //given
        Optional<Comment> comment = commentRepository.findById(14L);

        Assert.assertTrue(comment.isPresent());

        //when
        comment.ifPresent(c->{
            commentRepository.delete(c);
        });

        Optional<Comment> deleteComment = commentRepository.findById(14L);

        //then
        Assert.assertFalse(deleteComment.isPresent());
    }
}

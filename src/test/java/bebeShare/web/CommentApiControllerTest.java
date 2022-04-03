package bebeShare.web;

import bebeShare.domain.comment.Comment;
import bebeShare.domain.comment.CommentRepository;
import bebeShare.domain.product.Product;
import bebeShare.domain.user.User;
import bebeShare.service.CommentsService;
import bebeShare.web.dto.CommentUpdateRequestsDto;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
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
public class CommentApiControllerTest {

    @Autowired
    private CommentRepository commentRepository;


    @Test
    public void 댓글작성() throws Exception {
        //given
        String testComment = "This is test content";

        Comment comment = new Comment();
        comment.setId(123L);
        comment.setCommentContent(testComment);

        //when
        Comment newComment = commentRepository.save(comment);

        //then
        Assertions.assertThat(newComment.getCommentContent()).isEqualTo(testComment);
    }


//    private CommentUpdateRequestsDto updateRequestsDto;
//    private CommentsService commentsService;
//
//    @Test
//    public void 댓글수정() throws Exception {
//        //given
//        Long productId = 12L;
//        Long commentId = 14L;
//        Long memberId = 3L;
//        String commentContent = "수정한 댓글";related to
//
//        //when
//        commentsService.update(productId, commentId, updateRequestsDto);
//
//        //then
//        Assert.assertEquals(commentRepository.getById(commentId).getCommentContent(), commentContent);
//    }

    @Test
    public void 댓글삭제() throws Exception {

        //given
        Comment comment = new Comment();
        comment.setId(123L);
        comment.setCommentContent("This is test content");

        commentRepository.save(comment);

        //when
        commentRepository.delete(comment);

        Optional<Comment> deleteComment = commentRepository.findById(123L);

        //then
        Assert.assertFalse(deleteComment.isPresent());
    }
}

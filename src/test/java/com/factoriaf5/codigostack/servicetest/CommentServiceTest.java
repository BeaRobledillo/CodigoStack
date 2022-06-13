package com.factoriaf5.codigostack.servicetest;

import com.factoriaf5.codigostack.model.Comment;
import com.factoriaf5.codigostack.model.Post;
import com.factoriaf5.codigostack.repository.CommentRepository;
import com.factoriaf5.codigostack.repository.UserRepository;
import com.factoriaf5.codigostack.service.CommentService;
import com.factoriaf5.codigostack.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

class CommentServiceTest {

    @Mock
    private CommentRepository commentRepositoryMock;

    private CommentService commentServiceUnderTest;

    @BeforeEach
    void setUp() {
        commentServiceUnderTest = new CommentService(commentRepositoryMock);
    }

    @Test
    void getAllComentsTest() {
        //When
        commentServiceUnderTest.getAll();
        //Then
        verify(commentRepositoryMock).findAll();
    }

    @Test
    void commentByIdTest() {
        //When
        commentServiceUnderTest.commentById(2L);
        ArgumentCaptor<Long> commentIdArgumentCaptor = ArgumentCaptor.forClass(Long.class);

        //Then
        verify(commentRepositoryMock).findById(commentIdArgumentCaptor.capture());
        Long capturedCommentId = commentIdArgumentCaptor.getValue();

        assertThat(capturedCommentId).isEqualTo(2L);
    }

    @Test
    void createCommentTest(Comment comment) {
        //When
        Comment comment1 = new Comment("esto es un comentario para un post");
        commentServiceUnderTest.createComment(comment);
        //Then
        verify(commentRepositoryMock).save(comment);
    }

    @Test
    void deleteCommentTest() {
    }
}
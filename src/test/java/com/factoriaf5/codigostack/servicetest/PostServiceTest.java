package com.factoriaf5.codigostack.servicetest;


import com.factoriaf5.codigostack.model.Post;
import com.factoriaf5.codigostack.repository.PostRepository;
import com.factoriaf5.codigostack.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

public class PostServiceTest {
    @Mock private PostRepository postRepositoryMock;

    private PostService postServiceUnderTest;

    @BeforeEach
    void setUp() {
        postServiceUnderTest = new PostService(postRepositoryMock);
    }

    @Test
    void getAllPostsTest() {
        //When
        postServiceUnderTest.getAllPosts();
        // Then
        verify(postRepositoryMock).findAll();
    }

    @Test
    void postByIdTest() {
        //When
        postServiceUnderTest.postById(3L);

        ArgumentCaptor<Long> postIdArgumenCaptor = ArgumentCaptor.forClass(Long.class);
        // Then
        verify(postRepositoryMock).findById(postIdArgumenCaptor.capture());

        Long caputredPostId = postIdArgumenCaptor.getValue();

        assertThat(caputredPostId).isEqualTo(3L);
    }

    @Test
    void createPostTest() {
        //When
        Post post1 = new Post("Javascript with springboot principiantes","https://www.sololearn.com/profile/24621770", "Recomendo el curso gratuïto de sololearn" , LocalDate.now());
        postServiceUnderTest.createPost(post1);
        verify(postRepositoryMock).save(post1);

        }

    @Test
    void deletebyIdTest() {
        //When
        postServiceUnderTest.delete(1L);

        ArgumentCaptor<Long> deleteIdArgumenCaptor = ArgumentCaptor.forClass(Long.class);
        // Then
        verify(postRepositoryMock).deleteById(deleteIdArgumenCaptor.capture());

        Long caputredPostId = deleteIdArgumenCaptor.getValue();

        assertThat(caputredPostId).isEqualTo(1L);
    }

}
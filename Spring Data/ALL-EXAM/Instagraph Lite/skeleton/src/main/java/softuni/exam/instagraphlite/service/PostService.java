package softuni.exam.instagraphlite.service;

import java.io.IOException;

public interface PostService {
    Boolean аreImported();
    String readFromFileContent() throws IOException;
    String importPosts() throws IOException;

}

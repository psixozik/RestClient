package org.example.rest.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "articles")
public class NYTArticleDBModel {

    @Id
    private String id;
    @Indexed(unique = true)
    private String date;
    private List<Doc> listOfArticles;

    @Data
    public static class Doc{

        @JsonProperty("abstract") public String abStract;
        public String web_url;
        public String snippet;
        public String lead_paragraph;
        public String source;
        public Date pub_date;
        public String document_type;
        public String news_desk;
        public String section_name;
        public String type_of_material;
        public String _id;
        public int word_count;
        public String uri;
        public String print_section;
        public String print_page;
        public String subsection_name;
    }
}

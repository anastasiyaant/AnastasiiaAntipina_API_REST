package dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class YandexSpellerDTO {
    private int code;
    private int pos;
    private int row;
    private int col;
    private int len;
    private String word;
    private List<String> s;
}

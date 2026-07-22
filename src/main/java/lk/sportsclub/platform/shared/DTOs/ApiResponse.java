package lk.sportsclub.platform.shared.DTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private boolean success;
    private T data;
    private ErrorDetail error;

    public static <T> ApiResponse<T> success(T data){
        return new ApiResponse<>(true, data, null);
    }

    public static <T> ApiResponse<T> error(ErrorDetail error){
        return new ApiResponse<>(false, null, error);
    }
}

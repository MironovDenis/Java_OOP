package util.mapper;

import model.User;

public interface Mapper {
    String toInput(User e);
    User toOutput(String str);
}

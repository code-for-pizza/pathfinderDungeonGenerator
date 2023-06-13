package com.pathfinderGenerator.app.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StyleRequest {
    @Override
    public String toString() {
        return "StyleRequest{" +
                "styleName='" + styleName + '\'' +
                ", partySize=" + partySize +
                ", partyLevel=" + partyLevel +
                ", traits=" + traits +
                ", source=" + source +
                '}';
    }

    private String styleName;

    private int partySize;

    private int partyLevel;

    private List<String> traits;

    private List<String> source;




}

/*
"Gritty Adventure", 4, 3, traits
 */
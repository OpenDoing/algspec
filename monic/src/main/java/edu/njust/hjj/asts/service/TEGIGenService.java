package edu.njust.hjj.asts.service;

import edu.njust.hjj.asts.bean.Node;
import edu.njust.hjj.asts.bean.Operation;
import edu.njust.hjj.asts.bean.TEGI;

import java.util.List;

public interface TEGIGenService {
    public List<Node> generateTEG(TEGI tegi, String specName, List<String> termList, int equalType, boolean edgType);

    public void generateTEGI(TEGI tegi, String specName, String term, boolean edgType);
}



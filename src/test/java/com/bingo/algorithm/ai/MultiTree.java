package com.bingo.algorithm.ai;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangge created on 2019-03-04
 * @version $Id$
 */
public class MultiTree {

    @Test
    public void main() {


    }

    private void buildTestTree() {
        buildNode(2);
        buildNode(0);
        buildNode(2);

        buildNode(3);
    }

    private Node buildNode(int number) {
        Node node = new Node();
        if (number > 0) {
            node.nodeList = getNodes(number);
        }
        return node;
    }

    private List<Node> getNodes(int number) {
        LinkedList<Node> nodes = new LinkedList<>();
        for (int i = 0; i < number; i++) {
            nodes.add(new Node());
        }
        return nodes;
    }


    public static class Node {
        public List<Node> nodeList;
    }

}


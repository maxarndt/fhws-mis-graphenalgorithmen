package de.fhws.fiw.mis.graph;

import org.jgrapht.graph.ClassBasedEdgeFactory;
import org.jgrapht.graph.specifics.Specifics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * Created by maxarndt on 05.04.17.
 */
public class UndirectedBaseGraph extends AbstractGraph {
    public UndirectedBaseGraph() {

    }

    @Override
    public Set<Edge> getAllEdges(Vertex sourceVertex, Vertex targetVertex) {
        return null;
    }

    @Override
    public Edge getEdge(Vertex sourceVertex, Vertex targetVertex) {
        return null;
    }

    @Override
    public boolean containsEdge(Vertex sourceVertex, Vertex targetVertex) {
        return false;
    }

    @Override
    public Collection<Vertex> getNeighbors(Vertex vertex) {
        Collection<Vertex> vertices = new ArrayList<>();
        Set<Edge> edges = getEdgesOf(vertex);
        for(Edge edge : edges) {
            Vertex neighbor = getEdgeSource(edge);
            if(neighbor.equals(vertex)) neighbor = getEdgeTarget(edge);
            if(!neighbor.equals(vertex)) vertices.add(neighbor);
        }
        return vertices;
    }

    public boolean hasEulerianCircuit() {
        return isConnected() && getVertexSet().stream()
                .allMatch(x -> getEdgesOf(x).size() % 2 == 0);
    }
    public boolean hasEulerianPath() {
        return isConnected() && getVertexSet().stream()
                .filter(x -> getEdgesOf(x).size() % 2 == 1).count() == 2;
    }
    public boolean hasCycle() {
        return getEdgeSet().size() >= getVertexSet().size();
    }
}

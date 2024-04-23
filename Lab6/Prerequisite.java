package lab6CS146;
import java.util.*;

public class Prerequisite {

	public static boolean canFinish(int numCourses, int[][] prerequisites)
	{
		boolean canFinish = true;
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < numCourses; i++)
		{
			adjList.add(new ArrayList<>());		
		}
		
		// init an array keeping track of in degree count for each [a_i, b_i].
		int[] inDegree = new int[numCourses];
		
		for (int[] prerequisite : prerequisites)
		{
			int outDegNode = prerequisite[0];
			int inDegNode = prerequisite[1];
			
			//to the adjacency list, the out degree node connecting to the in degree node is added.
			adjList.get(outDegNode).add(inDegNode);
			inDegree[inDegNode]++;
		}
		
		//Creating a queue to store vertices with in-degree = 0.
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++)
		{
			if (inDegree[i] == 0) queue.add(i);
		}
		
		//topological sort implementation
		int count = 0;
		while (!queue.isEmpty())
		{
			int course = queue.poll();
			count++;
			for (int neighbor : adjList.get(course))
			{
				inDegree[neighbor]--;
				if (inDegree[neighbor] == 0) queue.add(neighbor);
			}
		}
		
		if (count != numCourses) canFinish = false;
		return canFinish;
	}
	
	public static void printArray(int[][] array)
	{
		for (int[] num : array)
		{
			System.out.print("[" + num[0]);
			System.out.print(" " + num[1] + "] ");
		}
	}
	
	public static void main(String[] args)
	{
		
		int[][] hasCycle = {{1, 2}, {2, 3}, {3, 1}};
		
		printArray(hasCycle);
		System.out.println();
		
		System.out.println(canFinish(4, hasCycle));
		
		int[][] loop = {{1, 1}};
		
		printArray(loop);
		System.out.println();
		
		System.out.println(canFinish(2, loop));
		
int[][] noCycle = {{1, 2}, {2, 3}, {3, 4}, {2, 5}};
		
		printArray(noCycle);
		System.out.println();
		
		System.out.println(canFinish(6, noCycle));
	}
	
}

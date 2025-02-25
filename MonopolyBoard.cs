using System.Collections.Generic;
using UnityEngine;

public class MonopolyBoard : MonoBehaviour
{
    /*Basic logic is let every spaces in MonopolyNode gameobjects, Store every spaces of the game board as an array.*/
    [SerializeField] List<MonopolyNode> route = new List<MonopolyNode>();
    //Let all new-added node into the gameboard gameobjects
    void OnValidate()
    {
        route.Clear();
        foreach (Transform node in transform.GetComponentInChildren<Transform>()) 
        {
            MonopolyNode mn = node.GetComponent<MonopolyNode>();
            if (mn != null)
            {
                route.Add(mn);
            }
        }
    }
    //Let every node combine with the green line for good visiable testing
    void OnDrawGizmos()
    {
        if (route == null || route.Count < 2) return;
        Gizmos.color = Color.green;
        for (int i = 0; i < route.Count - 1; i++)
        {
            if (route[i] != null && route[i + 1] != null)
            {
                Gizmos.DrawLine(route[i].transform.position, route[i + 1].transform.position);
            }
        }
    }
}

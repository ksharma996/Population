import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SortMethods - Sorts an array of Integers in ascending order.
 *
 * @author Kern Sharma
 * @since 1-12-23
 */
public class SortMethods
{

    /**
     * Bubble Sort algorithm - in ascending order
     *
     * @param list of city objects to sort
     */
    public void bubbleSort(List<City> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            for (int j = 0; j < list.size(); j++)
            {
                if (j < i && list.get(j).getPopulation() > list.get(i).getPopulation())
                    swap(list, i, j);
            }
        }
    }

    /**
     * Swaps two City objects in City List
     *
     * @param list a of Integer objects
     * @param x    index of first object to swap
     * @param y    index of second object to swap
     */
    private void swap(List<City> list, int x, int y)
    {
        City temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, temp);
    }

    /**
     * Selection Sort algorithm - in ascending order
     *
     * @param list of City objects to sort
     */
    public void selectionSort(List<City> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++)
            {
                if (list.get(j).getPopulation() < list.get(minIndex).getPopulation())
                {
                    minIndex = j;
                }
            }
            swap(list, minIndex, i);
        }
    }

    /**
     * Insertion Sort algorithm to sort city names in ascending order
     *
     * @param list array of Integer objects to sort
     */
    public void insertionSort(List<City> list)
    {
        for (int i = 1; i < list.size() - 1; i++)
        {
            City city = list.get(i);

            int j = i - 1;
            while (j >= 0 && city.getName().compareTo(list.get(j).getName()) < 0)
            {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, city);
        }
    }

    /**
     * Merge Sort algorithm
     *
     * @param list array of Integer objects to sort
     * @param left left index
     * @param right right index
     * @param sortType 1 for population descending order, 2 for city name in descending order
     */
    public static void mergeSort(List<City> list, int left, int right, int sortType)
    {
        if (left < right)
        {

            int mid = left + (right - left) / 2;

            mergeSort(list, left, mid, sortType);
            mergeSort(list, mid + 1, right, sortType);

            merge(list, left, mid, right, sortType);
        }
    }

    public static void merge(List<City> list, int leftIndex, int mid, int rightIndex, int sortType)
    {

        // build and fill temp lists for left and right and merge them after sorting

        int leftListSize = mid - leftIndex + 1;
        int rightListSize = rightIndex - mid;

        List<City> leftList = new ArrayList<>();
        List<City> rightList = new ArrayList<>();

        for (int i = 0; i < leftListSize; ++i)
            leftList.add(list.get(leftIndex + i));

        for (int j = 0; j < rightListSize; ++j)
            rightList.add(list.get(mid + 1 + j));

        int i = 0, j = 0;

        int k = leftIndex;

        while (i < leftListSize && j < rightListSize)
        {
            //population descending order
            if (sortType == 1)
            {
                if (leftList.get(i).getPopulation() >= rightList.get(j).getPopulation())
                {
                    list.set(k, leftList.get(i));
                    i++;
                }
                else
                {
                    list.set(k, rightList.get(j));
                    j++;
                }
                k++;
            }
            // city name descending order
            else if (sortType == 2)
            {
                if (leftList.get(i).getName().compareTo(rightList.get(j).getName()) >= 0)
                {
                    list.set(k, leftList.get(i));
                    i++;
                }
                else
                {
                    list.set(k, rightList.get(j));
                    j++;
                }
                k++;
            }
        }

        // add remaining values
        while (i < leftListSize)
        {
            list.set(k, leftList.get(i));
            i++;
            k++;
        }

        // add remaining values
        while (j < rightListSize)
        {
            list.set(k, rightList.get(j));
            j++;
            k++;
        }
    }


    /*****************************************************************/
    /************************* For Testing ***************************/
    /*****************************************************************
    public static void main(String[] args)
    {
        City a = new City("a", "a", "a", 1);
        City b = new City("b", "b", "b", 2);
        City c = new City("c", "c", "c", 3);
        City d = new City("d", "d", "d", 14);
        City e = new City("e", "e", "e", 5);

        List<City> list = new ArrayList<>();
        list.add(e);
        list.add(b);
        list.add(a);
        list.add(d);
        list.add(c);

        SortMethods sm = new SortMethods();

        ArrayList tempList = new ArrayList(list);
        sm.bubbleSort(tempList);
        System.out.println("BubbleSort\n\n" + Arrays.asList(tempList));

        tempList = new ArrayList(list);
        System.out.println(Arrays.asList(tempList));
        sm.selectionSort(tempList);
        System.out.println("SelectionSort\n\n" + Arrays.asList(tempList));

        tempList = new ArrayList(list);
        System.out.println(Arrays.asList(tempList));
        sm.insertionSort(tempList);
        System.out.println("InsertionSort\n\n" + Arrays.asList(tempList));

        tempList = new ArrayList(list);
        System.out.println(Arrays.asList(tempList));
        sm.mergeSort(tempList, 0, tempList.size() - 1, 1);
        System.out.println("MergeSort\n\n" + Arrays.asList(tempList));

        tempList = new ArrayList(list);
        System.out.println(Arrays.asList(tempList));
        sm.mergeSort(tempList, 0, tempList.size() - 1, 2);
        System.out.println("MergeSort\n\n" + Arrays.asList(tempList));

    }
    */

}

// https://www.youtube.com/watch?v=iVhmR1bzKoo&list=PLK0ZC7fyo01Jr4CwyEGPB_YYVYqoJS7LR&index=54&t=0s

class Solution {
    public List<Integer> getRow(int rowIndex) {
       List<Integer> result = new ArrayList();
        for (int i = 0; i <= rowIndex; i++) {
            result.add(0, 1);
            for (int j = 1; j < result.size() - 1; j++)
                result.set(j, result.get(j) + result.get(j + 1));
        }
        return result;
    }
}
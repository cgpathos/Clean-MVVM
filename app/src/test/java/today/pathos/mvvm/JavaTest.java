package today.pathos.mvvm;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class JavaTest {

    @Test
    public void t4() {
        assertEquals(solution(new int[]{3, 4, 5, 1}, new int[]{4, 2, 5, 3, 2}), 3);
        assertEquals(solution(new int[]{4, 2, 5, 3, 2}, new int[]{3, 4, 5, 1}), 3);
        assertEquals(solution(new int[]{2, 1}, new int[]{3, 3}), -1);
    }

    int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n; k++) {
//            if (i < m - 1 && B[i] < A[k]) //          this is org code
            while (i < m - 1 && B[i] < A[k])
                i += 1;
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }
}

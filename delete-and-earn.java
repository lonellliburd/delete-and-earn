public static long maxPoints(List<Integer> elements) {
    if (elements.size() == 0) {
        return 0;
    }

    if (elements.size() == 1) {
        return elements.get(0);
    }

    int bins[] = new int[10001];
    int sum[] = new int[10001];
    int maxVal = 0;

    for (int n : elements) {
        bins[n]++;
        if (n > maxVal) {
            maxVal = n;
        }
    }

    sum[0] = bins[0];
    sum[1] = bins[1];

    for (int i = 2; i <= maxVal; i++) {
        sum[i] = Math.max(sum[i - 2] + bins[i] * i, sum[i - 1]);
    }

    return sum[maxVal];
}
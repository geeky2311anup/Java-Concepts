#include <iostream>

using namespace std;

static inline bool possible(long long n, long long m,
                            long long p, long long q) {

    if (n % p) {
        return true;
    }

    long long groups = n / p;
    return groups * q == m;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int tc;
    cin >> tc;

    while (tc--) {
        long long a, b, c, d;
        cin >> a >> b >> c >> d;

        if (possible(a, b, c, d)) {
            cout << "YES\n";
        } else {
            cout << "NO\n";
        }
    }

    return 0;
}

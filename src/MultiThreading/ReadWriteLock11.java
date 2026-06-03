#include <iostream>

using namespace std;

void solve() {
    long long n, m, p, q;
    cin >> n >> m >> p >> q;

    if (n % p == 0) {
        if (m == (n / p) * q) {
            cout << "YES\n";
        } else {
            cout << "NO\n";
        }
    } else {
        // Since elements can be negative integers, we have infinite degrees of 
        // freedom to construct the remainder sum sequence.
        cout << "YES\n";
    }
}

int main() {
    // Fast I/O
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    if (cin >> t) {
        while (t--) {
            solve();
        }
    }
    return 0;
}

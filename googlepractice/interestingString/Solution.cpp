int to_integer(string S, int from, int to)
{
    int res = 0;
    for(int i = from; i <= to; i++) {
        res = res * 10 + S[i] - '0';
    }
    return res;
}

bool dfs(string S, int idx)
{
    if(idx == S.length()) {
        return true;
    }
    int i = idx;
    while(i < S.length() and isdigit(S[i])) {
        int offset = to_integer(S, idx, i);
        if(dfs(S, i + offset + 1))
            return true;
        i++;
    }
    return false;
}

bool is_interesting_string(string S) {
    return dfs(S, 0);
}


int main()
{ 
    
    string S = "4g12y6hunter";
    assert(is_interesting_string(S) == true);
    S = "124gray6hunter";
    assert(is_interesting_string(S) == true);
    S = "31ba2a";
    assert(is_interesting_string(S) == false);
    S = "3abc4defg3abc4defg3abc";
    assert(is_interesting_string(S) == true);
    S = "10abcasdfase4defg3abc4defg3abc";
    assert(is_interesting_string(S) == true);
    return 0;
}

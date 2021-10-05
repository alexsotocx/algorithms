package google

import "testing"

func Test_decodeString(t *testing.T) {
	type args struct {
		s string
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{name: "a", args: args{s: "3[a]2[bc]"}, want: "aaabcbc"},
		{name: "b", args: args{s: "abcde"}, want: "abcde"},
		{name: "c", args: args{s: "3[a2[c]]"}, want: "accaccacc"},
		{name: "c", args: args{s: "2[abc]3[cd]ef"}, want: "abcabccdcdcdef"},
		{name: "d", args: args{s: "2[2[ab]cde3[f]]"}, want: "ababcdefffababcdefff"},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := decodeString(tt.args.s); got != tt.want {
				t.Errorf("decodeString() = %v, want %v", got, tt.want)
			}
		})
	}
}

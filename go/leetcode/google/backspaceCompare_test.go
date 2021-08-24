package google

import "testing"

func Test_backspaceCompare(t *testing.T) {
	type args struct {
		s string
		t string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{name: "test", args: args{"ab#c", "ad#c"}, want: true},
		{name: "test", args: args{"ab##", "c#d#"}, want: true},
		{name: "test", args: args{"a##c", "#a#c"}, want: true},
		{name: "test", args: args{"", "ac###"}, want: true},
		{name: "test", args: args{"a#c", "b"}, want: false},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := backspaceCompare(tt.args.s, tt.args.t); got != tt.want {
				t.Errorf("backspaceCompare() = %v, want %v", got, tt.want)
			}
		})
	}
}

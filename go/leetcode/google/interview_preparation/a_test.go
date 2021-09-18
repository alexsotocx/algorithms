package google

import "testing"

func Test_resolve(t *testing.T) {
	type args struct {
		args []string
	}
	tests := []struct {
		name    string
		args    args
		want    string
		wantErr bool
	}{
		{name: "first", args: args{[]string{"/usr/user_a/home", "..", "desktop", "../.."}}, want: "/usr"},
		{name: "second", args: args{[]string{"/usr/user_a/home", "..", "desktop", "../../user_b"}}, want: "/usr/user_b"},
		{name: "third", args: args{[]string{"/usr/user_a/home", "..", "desktop", "../../../..", "user_b"}}, wantErr: true},
		{name: "fourth", args: args{[]string{"/usr/user_a/home", "..", "desktop", "../..", ".."}}, want: "/"},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			got, err := resolve(tt.args.args...)
			if (err != nil) != tt.wantErr {
				t.Errorf("resolve() error = %v, wantErr %v", err, tt.wantErr)
				return
			}
			if got != tt.want {
				t.Errorf("resolve() = %v, want %v", got, tt.want)
			}
		})
	}
}

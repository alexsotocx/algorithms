package google

import "testing"

func TestFindClosestApartment(t *testing.T) {
	type args struct {
		blocks       []map[string]bool
		requirements []string
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{name: "Just one", args: args{blocks: []map[string]bool{{"house": true, "school": false}}, requirements: []string{"house"}}, want: 0},
		{name: "Test2", args: args{blocks: []map[string]bool{{"house": true, "school": false}, {"house": false, "school": true}}, requirements: []string{"house", "school"}}, want: 0},
		{name: "Test3", args: args{blocks: []map[string]bool{{"house": true, "school": false, "shop": false}, {"house": false, "school": true, "shop": false}, {"house": false, "school": false, "shop": true}}, requirements: []string{"house", "school", "shop"}}, want: 1},
		{name: "Test4", args: args{blocks: []map[string]bool{{"house": true, "school": false, "shop": false}, {"house": true, "school": true, "shop": true}, {"house": false, "school": true, "shop": false}}, requirements: []string{"house", "school", "shop"}}, want: 1},
		{name: "Not matching criteria", args: args{blocks: []map[string]bool{{"house": false, "school": false, "shop": false}, {"house": false, "school": false, "shop": false}, {"house": false, "school": false, "shop": false}}, requirements: []string{"house", "school", "shop"}}, want: -1},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := FindClosestApartment(tt.args.blocks, tt.args.requirements); got != tt.want {
				t.Errorf("FindClosestApartment() = %v, want %v", got, tt.want)
			}
		})
	}
}

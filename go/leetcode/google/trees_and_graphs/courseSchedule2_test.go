package google

import (
	"reflect"
	"testing"
)

func Test_findOrder(t *testing.T) {
	xd := [][]int{{1, 0}, {2, 0}, {3, 1}, {3, 2}}
	type args struct {
		numCourses    int
		prerequisites [][]int
	}
	tests := []struct {
		name string
		args args
		want []int
	}{
		// {name: "2", args: args{numCourses: 2, prerequisites: [][]int{{1, 0}}}, want: []int{0, 1}},
		{name: "3", args: args{numCourses: 4, prerequisites: xd}, want: []int{0, 2, 1, 3}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := findOrder(tt.args.numCourses, tt.args.prerequisites); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("findOrder() = %v, want %v", got, tt.want)
			}
		})
	}
}

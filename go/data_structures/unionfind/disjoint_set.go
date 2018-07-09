package unionfind

type DisjointSet struct {
	rank   []int
	parent []int
	sets   int
}

func (d *DisjointSet) find(i int) int {
	if i == d.parent[i] {
		return i
	}
	d.parent[i] = d.find(d.parent[i])
	return d.parent[i]
}

func (d DisjointSet) Sets() int {
	return d.sets
}

func (d *DisjointSet) SameSet(i, j int) bool {
	return d.find(i) == d.find(j)
}

func (d *DisjointSet) Join(i, j int) bool {
	pi, pj := d.find(i), d.find(j)
	if pi != pj {
		if d.rank[pi] >= d.rank[pj] {
			d.parent[pj] = pi
			d.rank[pi]++
			d.sets--
		} else {
			d.parent[pi] = pj
			d.rank[pj]++
			d.sets--
		}
		return true
	}
	return false
}

func New(size int) *DisjointSet {
	rank := make([]int, size)
	parent := make([]int, size)

	for i := 0; i < size; i++ {
		parent[i] = i
	}
	return &DisjointSet{
		rank:   rank,
		parent: parent,
		sets:   size,
	}
}

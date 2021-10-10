package google

type IRobot interface {
	Move() bool
	TurnLeft()
	TurnRight()
	Clean()
}

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * type Robot struct {
 * }
 *
 * // Returns true if the cell in front is open and robot moves into the cell.
 * // Returns false if the cell in front is blocked and robot stays in the current cell.
 * func (robot *Robot) Move() bool {}
 *
 * // Robot will stay in the same cell after calling TurnLeft/TurnRight.
 * // Each turn will be 90 degrees.
 * func (robot *Robot) TurnLeft() {}
 * func (robot *Robot) TurnRight() {}
 *
 * // Clean the current cell.
 * func (robot *Robot) Clean() {}
 */
type xy struct {
	a, b int
}

// DIR -> 0 = N, 1 = E, 2 = S, 3 = W
var movR = []xy{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}

func cleanRoom(robot IRobot) {
	visited := make(map[xy]bool)
	initialPos := xy{0, 0}
	clean(robot, visited, initialPos, 0)
}

func clean(robot IRobot, visited map[xy]bool, initialPos xy, direction int) {
	visited[initialPos] = true
	robot.Clean()
	i := 0
	for i < 4 {
		newDir := (direction + i) % 4
		newPos := xy{initialPos.a + movR[newDir].a, initialPos.b + movR[newDir].b}
		if !visited[newPos] {
			rotateRobotTo(robot, direction, newDir)
			if robot.Move() {
				clean(robot, visited, newPos, newDir)
				moveRobotToInitialPos(robot)
				newDir = (newDir + 2) % 4 // 180 degree rotation
			}
			rotateRobotTo(robot, newDir, direction)
		}

		i++
	}
}

// Robot is in an adjacent cell
func moveRobotToInitialPos(robot IRobot) {
	// Rotate the robot 180 degrees and back to the cell
	robot.TurnRight()
	robot.TurnRight()
	robot.Move()
}

func rotateRobotTo(robot IRobot, initial, target int) {
	for target != initial {
		initial = (initial + 1) % 4
		robot.TurnRight()
	}
}

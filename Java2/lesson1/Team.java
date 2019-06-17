package Lesson_1;

class Team {
    private String teamName;
    private Member [] memberList;

    Team(String name, Member[] members) {
        this.teamName = name;
        this.memberList = members;
    }

    Member[] getMembers(){
        return this.memberList;
    }

    private String getName(){
        return teamName;
    }

    private StringBuilder membersInfo(){
        StringBuilder players = new StringBuilder();
        for (Member member : this.memberList) {
            players.append(member.toString()).append(",\n ");
        }
        return players;
    }

    @Override
    public String toString() {
        return "Team { " + getName() +":\n" + membersInfo() + "}";
    }

}

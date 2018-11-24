package Ball;

public class Ball {
    private String BallName=null;
    private double Radius=0;
    private double Weight=0;
    private double Price=0;
    Ball(){}
    Ball(String _BallName,double _Radius,double _Weight,double _Price) {
        this.BallName=_BallName;
        this.Radius=_Radius;
        this.Weight=_Weight;
        this.Price=_Price;
    }
    private void SetInfo(String _BallName,double _Radius,double _Weight,double _Price) {
        this.BallName=_BallName;
        this.Radius=_Radius;
        this.Weight=_Weight;
        this.Price=_Price;
    }
    public void Play() {};
}


class FootBall extends Ball {
    FootBall(){super();}
    FootBall(String _BallName,double _Radius,double _Weight,double _Price){super(_BallName,_Radius,_Weight,_Price);}
    @Override
    public void Play () {
        System.out.println("Playing the football by your feet!");
    }
}

class BasketBall extends Ball {
    BasketBall(){super();}
    BasketBall(String _BallName,double _Radius,double _Weight,double _Price){super(_BallName,_Radius,_Weight,_Price);}
    @Override
    public void Play () {
        System.out.println("Playing the basketball by your hands!");
    }
}

class PingPong extends Ball {
    PingPong(){super();}
    PingPong(String _BallName,double _Radius,double _Weight,double _Price){super(_BallName,_Radius,_Weight,_Price);}
    @Override
    public void Play () {
        System.out.println("Playing the pingpong by your ping pong paddles!");
    }
}
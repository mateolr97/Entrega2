public class AVLTree {
    private Node root;
    private int size;

    public AVLTree() {
        this.size=0;
    }

    //Getters and Setters
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    
    
    //Methods
    
    public int height(Node n){
        if(n==null){
            return -1;
        }
        return 1+Math.max(height(n.getLeft()),height(n.getRight()));  
    }
    
    public void adjustHeight(Node n){
       n.setHeight(1+Math.max(n.getLeft().getHeight(),n.getRight().getHeight()));
   }
    
      public int nodeHeight(Node n){
        if(n==null){
                return -1;
        }
        
            if(n.getLeft()==null&&n.getRight()==null){
                return 1;
            }else if (n.getLeft()==null){
                return 1+nodeHeight(n.getRight());
            }else if (n.getRight()==null){
                return 1+nodeHeight(n.getLeft());
            }else{
                return 1+Math.max(nodeHeight(n.getLeft()),nodeHeight(n.getRight()));
            }
    }
    
    public void nodesHeight(Node n){
        if(n!=null){
                n.setHeight(this.nodeHeight(n));
                nodesHeight(n.getLeft());
                nodesHeight(n.getRight());
            }
    }
    
    //Rotations
   public void rotateRight(Node x){
       Node p=new Node();
       Node y=new Node();
       Node b=new Node();
       p=x.getParent();
       y=x.getLeft();
       if(y!=null){
          b=y.getRight();
          y.setParent(p);
          if(x.getParent()!=null){
                if(x.getParent().getKey().getVida()>y.getKey().getVida()){
                    x.getParent().setLeft(y);
                }else if(x.getParent().getKey().getVida()<y.getKey().getVida()){
                    x.getParent().setRight(y);
                }
            }    
       }
       
       
       x.setParent(y);
       if(y!=null){
           y.setRight(x);
           if(b!=null){
               b.setParent(x);
           }
           
       }
       
       
       x.setLeft(b);
       if(x==this.root){
           this.root=y;
       }   
   }
   
  public void rotateLeft(Node x){
       Node p=new Node();
       Node y=new Node();
       Node b=new Node();
       p=x.getParent();
       y=x.getRight();
       if(y!=null){
          b=y.getLeft();
          y.setParent(p);
          if(x.getParent()!=null){
                if(x.getParent().getKey().getVida()>y.getKey().getVida()){
                    x.getParent().setLeft(y);
                }else if(x.getParent().getKey().getVida()<y.getKey().getVida()){
                    x.getParent().setRight(y);
                }
            }    
       }
       
       
       x.setParent(y);
       if(y!=null){
           y.setLeft(x);
           if(b!=null){
               b.setParent(x);
           }
           
       }
       
       
       x.setRight(b);
       if(x==this.root){
           this.root=y;
       }   
   }
   
   public void rebalanceRight(Node n){
       Node m=new Node();
       int d=0,i=0;
       m=n.getLeft();
       if(m.getLeft()!=null&&m.getRight()!=null){
            if(m.getRight().getHeight()>m.getLeft().getHeight()){
                this.rotateLeft(m);
            }
       }else if(m.getRight()==null&&m.getLeft()!=null){
           d=0;
           if(d>m.getLeft().getHeight()){
                this.rotateLeft(m);
            }
       }else if(m.getRight()!=null&&m.getLeft()==null){
           if(m.getRight().getHeight()>i){
                this.rotateLeft(m);
            }
       }
       
       this.rotateRight(n);
       //Adjust height on affected nodes
       this.nodesHeight(this.root);  
   }
   
  public void rebalanceLeft(Node n){
       Node m=new Node();
       int d=0,i=0;
       m=n.getRight();
       if(m.getRight()!=null&&m.getLeft()!=null){
            if(m.getLeft().getHeight()>m.getRight().getHeight()){
                this.rotateRight(m);
            }
       }else if(m.getLeft()==null&&m.getRight()!=null){
           d=0;
           if(d>m.getRight().getHeight()){
                this.rotateRight(m);
            }
       }else if(m.getLeft()!=null&&m.getRight()==null){
           if(m.getLeft().getHeight()>i){
                this.rotateRight(m);
            }
       }
       
       this.rotateLeft(n);
       //Adjust height on affected nodes
       this.nodesHeight(this.root);  
   }
   
   public void rebalance(Node n){
       Node p=new Node();
       if(n.getParent()!=null){
            p=n.getParent();
       }else{
           p=null;
       }
       
       int d=0,i=0;
       if(n.getLeft()!=null&&n.getRight()!=null){
           i=n.getLeft().getHeight();
           d=n.getRight().getHeight();
           if(i>d+1){
                this.rebalanceRight(n);
            }

            if(d>i+1){
                this.rebalanceLeft(n);
            }
       }else if(n.getRight()!=null&&n.getLeft()==null){
           d=n.getRight().getHeight();
           i=0;
           
            if(d>i+1){
                this.rebalanceLeft(n);
            }
       }else if(n.getRight()==null&&n.getLeft()!=null){
           d=0;
           i=n.getLeft().getHeight();
           if(i>d+1){
                this.rebalanceRight(n);
            }
       }
       
       
       n.setHeight(this.nodeHeight(n));
       if(p!=null){
           this.rebalance(p);
       }
   }
    
    /*public int size(Node n){
        if(n==null){
            return 0;
        }
        return 1+size(n.getLeft())+size(n.getRight()); 
    }*/
    
    public Node find(int x,Node r){
        if(r.getKey().getVida()==x){
            return r;
        }else if(r.getKey().getVida()>x){
            if(r.getLeft()!=null){
                return find(x,r.getLeft());
            }
        }else if(r.getKey().getVida()<x){
            if(r.getRight()!=null){
                return find(x,r.getRight());
            }
        } 
        return r;       
    }
    
   public void insert(Enemigo k){ 
       Node x=new Node(k);
       if(this.root==null){
           this.root=x;
       }else{
            Node p=new Node();
            p=this.find(k.getVida(),this.root);
            if(p.getKey().getVida()>k.getVida()){
                p.setLeft(x);
                p.getLeft().setParent(p);       
            }else if(p.getKey().getVida()<k.getVida()){
                p.setRight(x);
                p.getRight().setParent(p);    
            }
       } 
    }
   
    public void insertAVL(Enemigo k){ 
       Node x=new Node(k);
       if(this.root==null){
           this.root=x;
           
       }else{
            Node p=new Node();
            p=this.find(k.getVida(),this.root);
            if(p.getKey().getVida()>k.getVida()){
                p.setLeft(x);
                p.getLeft().setParent(p);       
            }else if(p.getKey().getVida()<k.getVida()){
                p.setRight(x);
                p.getRight().setParent(p);    
            }
       } 
       this.size++;
       Node n=new Node();
       n=this.find(k.getVida(),this.root);
       this.rebalance(n);
    }
   
   //Next

   public Node rightAncestor(Node n){
       if(n.getParent()==null){
           return null;
       }
       
       if(n.getKey().getVida()<n.getParent().getKey().getVida()){
           return n.getParent();
       }else{
           return rightAncestor(n.getRight());
       }
   }
   
   public Node leftDescendant(Node n){
       if(n.getLeft()==null){
           return n;
       }else{
           return leftDescendant(n.getLeft());
       }
   }
   
   public Node next(Node n){
       if(n.getRight()!=null){
           return leftDescendant(n.getRight());
       }else{
           return rightAncestor(n);
       }
   }
    
   //Remove
   
   public void delete(Node n){
       
       if(n.getRight()==null){
           if(n.getParent().getKey().getVida()>n.getKey().getVida()){
               n.getParent().setLeft(n.getLeft());
               if(n.getLeft()!=null){
                   n.getLeft().setParent(n.getParent());
               }       
           }else if(n.getParent().getKey().getVida()>n.getKey().getVida()){
               n.getParent().setRight(n.getLeft());
               if(n.getLeft()!=null){  
                   n.getLeft().setParent(n.getParent());
               }  
           }  
           if(n==this.root){
               this.root=n.getLeft();
           }
       }else{
           Node x=new Node();
            x=this.next(n);
            x.getParent().setLeft(x.getRight());
            if(x.getRight()!=null){
                x.getRight().setParent(x.getParent());
            }
            x.setParent(n.getParent());
            x.setLeft(n.getLeft());
            x.setRight(n.getRight());
            if(n==this.root){
               this.root=x;
           }
       }       
   }
    
   public void deleteAVL(Node n){
       Node m=new Node();
       if(n.getRight()==null){
           if(n.getParent()!=null){
               if(n.getParent().getKey().getVida()>n.getKey().getVida()){
                    n.getParent().setLeft(n.getLeft());
                    if(n.getLeft()!=null){
                        n.getLeft().setParent(n.getParent());
                    }       
                }else if(n.getParent().getKey().getVida()>n.getKey().getVida()){
                    n.getParent().setRight(n.getLeft());
                    if(n.getLeft()!=null){  
                        n.getLeft().setParent(n.getParent());
                    }  
                }
           }
             
           if(n==this.root){
               this.root=n.getLeft();
           }
           m=n.getParent();
           this.size--;
           if(this.size==0){
                   this.root=null;
            }
       }else{
           Node x=new Node();
           
            x=this.next(n);
            m=x.getParent();
            x.getParent().setLeft(x.getRight());
            if(x.getRight()!=null){
                x.getRight().setParent(x.getParent());
            }
            x.setParent(n.getParent());
            x.setLeft(n.getLeft());
            x.setRight(n.getRight());
            this.size--;
            if(n==this.root){
               this.root=x;
               
           }
           if(this.size==0){
                   this.root=null;
            }
       }
       if(m!=null){
            this.rebalance(m);
       }
       
   }
    
}
